// The Main Entry Point for React App

// Ant Design
import {
    Layout,
    Menu,
    Breadcrumb,
    Table, Spin, Empty
} from "antd";
import {
    DesktopOutlined,
    PieChartOutlined,
    FileOutlined,
    TeamOutlined,
    UserOutlined,
    LoadingOutlined,
} from '@ant-design/icons';

// Styling
import './App.css';

// Manage App States
import { useState, useEffect } from 'react'

// API References
import {
    getAllAdmin
} from "./client";

const { Header, Content, Footer, Sider } = Layout;
const { SubMenu } = Menu;

const columns = [
    {
        title: 'Admin ID',
        dataIndex: 'adminId',
        key: 'adminId',
    },
    {
        title: 'Full Name',
        dataIndex: 'fullName',
        key: 'fullName',
    },
    {
        title: 'Email',
        dataIndex: 'email',
        key: 'email',
    },
    {
        title: 'Date of Birth',
        dataIndex: 'dob',
        key: 'dob',
    },
    {
        title: 'Mobile Number',
        dataIndex: 'mobileNumber',
        key: 'mobileNumber',
    },
    {
        title: 'Password',
        dataIndex: 'password',
        key: 'password',
    },
];

const antIcon = <LoadingOutlined style={{ fontSize: 24 }} spin />;

// FE Components
function App() {
    const [admins, setAdmins] = useState([]);
    const [collapsed, setCollapsed] = useState(false);
    const [fetching, setFetching] = useState(true);

    const fetchAdmins = () =>
        getAllAdmin()
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setAdmins(data)
                setFetching(false); // When loaded, set feching false
            })

    useEffect(() => { // Invokes function once
        console.log("Component Mounted")
        fetchAdmins(); // admins variable will contain the array
    },[]);

    const renderAdmins = () => {
        if (fetching) {
            return <Spin indicator={antIcon}/>
        }
        if (admins.length <= 0) {
            return <Empty />;
        }

        // Data Source
        return <Table
            dataSource={admins}
            columns={columns}
            bordered
            title={() => 'Admin'}
            pagination={{ pageSize: 50 }}
            scroll={{ y: 240 }}
            rowKey={(admin) => admin.adminId}
        />;
    }

    return <Layout style={{ minHeight: '100vh' }}>
        <Sider collapsible collapsed={collapsed}
               onCollapse={setCollapsed}>
            <div className="logo" />
            <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
                <Menu.Item key="1" icon={<PieChartOutlined />}>
                    Option 1
                </Menu.Item>
                <Menu.Item key="2" icon={<DesktopOutlined />}>
                    Option 2
                </Menu.Item>
                <SubMenu key="sub1" icon={<UserOutlined />} title="User">
                    <Menu.Item key="3">Tom</Menu.Item>
                    <Menu.Item key="4">Bill</Menu.Item>
                    <Menu.Item key="5">Alex</Menu.Item>
                </SubMenu>
                <SubMenu key="sub2" icon={<TeamOutlined />} title="Team">
                    <Menu.Item key="6">Team 1</Menu.Item>
                    <Menu.Item key="8">Team 2</Menu.Item>
                </SubMenu>
                <Menu.Item key="9" icon={<FileOutlined />}>
                    Files
                </Menu.Item>
            </Menu>
        </Sider>
        <Layout className="site-layout">
            <Header className="site-layout-background" style={{ padding: 0 }} />
            <Content style={{ margin: '0 16px' }}>
                <Breadcrumb style={{ margin: '16px 0' }}>
                    <Breadcrumb.Item>User</Breadcrumb.Item>
                    <Breadcrumb.Item>Bill</Breadcrumb.Item>
                </Breadcrumb>
                {/*Actual Content - Render Table*/}
                <div className="site-layout-background" style={{ padding: 24, minHeight: 360 }}>
                    {renderAdmins()}
                </div>
            </Content>
            <Footer style={{ textAlign: 'center' }}>Spring Master By Rome.Q</Footer>
        </Layout>
    </Layout>

}

export default App;
