// The Main Entry Point for React App

// Ant Design
import {Avatar, Badge, Breadcrumb, Button, Empty, Layout, Menu, Spin, Table, Tag, Radio, Popconfirm} from "antd";
import {
    FileOutlined,
    HistoryOutlined,
    LoadingOutlined,
    LockOutlined,
    PlusCircleFilled,
    TeamOutlined,
    UserOutlined,
} from '@ant-design/icons';

// AdminDrawerForm
import AdminDrawerForm from "./AdminDrawerForm";

// Styling
import './App.css';

// Manage App States
import {useEffect, useState} from 'react'

// API References
import {deleteAdmin, getAllAdmin} from "./client";
import {successNotification} from "./Notification";

const {Header, Content, Footer, Sider} = Layout;
const {SubMenu} = Menu;

const TheAvatar = ({name}) => {
    // If no name, return Avatar Icon
    let trim = name.trim();
    if (trim.length === 0) {
        return <Avatar icon={<UserOutlined/>}/>
    }
    // If single name E.g. Jerome, return J
    const split = trim.split(" ");
    if (split.length ===1) {
        return <Avatar>{name.charAt(0)}</Avatar>
    }
    // Return First Character and Last Character
    return <Avatar>
        {`${name.charAt(0)}${name.charAt(name.length-1)}`}
    </Avatar>
}

const removeAdmin = (adminId, callback) => {
    deleteAdmin(adminId).then(() => {
        successNotification("Admin Deleted", `Admin with id ${adminId} was deleted`);
        callback(); // fetchAdmin is called here to refresh table
    })
}

const columns = fetchAdmins => [
    {
        title: 'Logo',
        dataIndex: 'avatar',
        key: 'avatar',
        render: (text, admin) =>
            <TheAvatar name = {admin.fullName}/>
    },
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
    {
        title: 'Actions',
        key: 'actions',
        render: (text, admin) =>
            <Radio.Group>
                <Popconfirm
                    placement='topRight'
                    title={`Are you sure to delete ${admin.fullName} ?`}
                    onConfirm={() => removeAdmin(admin.adminId, fetchAdmins)}
                    okText='Yes'
                    cancelText='No'>
                    <Radio.Button value="small">Delete</Radio.Button>
                </Popconfirm>
                <Radio.Button value="small">Edit</Radio.Button>
            </Radio.Group>
    }
];

const antIcon = <LoadingOutlined style={{fontSize: 24}} spin/>;

// FE Components - the States
function App() {
    const [admins, setAdmins] = useState([]);
    const [collapsed, setCollapsed] = useState(false);
    const [fetching, setFetching] = useState(true);
    const [showDrawer, setShowDrawer] = useState(false);


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
    }, []);

    const renderAdmins = () => {
        if (fetching) {
            return <Spin indicator={antIcon}/>
        }

        // Returning Data
        return <>
            <AdminDrawerForm
                showDrawer={showDrawer}
                setShowDrawer={setShowDrawer}
                fetchAdmins = {fetchAdmins}
            />
            <Table
                dataSource={admins}
                columns={columns(fetchAdmins)}
                bordered
                title={() =>
                    <>
                        <Tag color="orange">Number of Admins</Tag>
                        <Badge count={admins.length} className="site-badge-count-4" />
                        <br/><br/>
                        {/*createAdmin Button*/}
                        <Button
                            onClick={() => setShowDrawer(!showDrawer)}
                            type="primary" shape="round" icon={<PlusCircleFilled/>} size="medium">
                            Add Admin
                        </Button>
                    </>}
                pagination={{pageSize: 50}}
                scroll={{y: 700}}
                rowKey={(admin) => admin.adminId}
            />
        </>
    }

    return <Layout style={{minHeight: '100vh'}}>
        <Sider collapsible collapsed={collapsed}
               onCollapse={setCollapsed}>
            <div className="logo"/>
            <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
                <Menu.Item key="1" icon={<UserOutlined/>}>
                    Admin
                </Menu.Item>
                <Menu.Item key="2" icon={<HistoryOutlined/>}>
                    Log
                </Menu.Item>
                <Menu.Item key="3" icon={<LockOutlined/>}>
                    Lock
                </Menu.Item>
                <SubMenu key="sub1" icon={<UserOutlined/>} title="User">
                    <Menu.Item key="3">Tom</Menu.Item>
                    <Menu.Item key="4">Bill</Menu.Item>
                    <Menu.Item key="5">Alex</Menu.Item>
                </SubMenu>
                <SubMenu key="sub2" icon={<TeamOutlined/>} title="Team">
                    <Menu.Item key="6">Team 1</Menu.Item>
                    <Menu.Item key="8">Team 2</Menu.Item>
                </SubMenu>
                <Menu.Item key="9" icon={<FileOutlined/>}>
                    Files
                </Menu.Item>
            </Menu>
        </Sider>
        <Layout className="site-layout">
            <Header className="site-layout-background" style={{padding: 0}}/>
            <Content style={{margin: '0 16px'}}>
                <Breadcrumb style={{margin: '16px 0'}}>
                    <Breadcrumb.Item>User</Breadcrumb.Item>
                    <Breadcrumb.Item>Bill</Breadcrumb.Item>
                </Breadcrumb>
                {/*Actual Content - Render Table*/}
                <div className="site-layout-background" style={{padding: 24, minHeight: 360}}>
                    {renderAdmins()}
                </div>
            </Content>
            <Footer style={{textAlign: 'center'}}>Spring Master By Rome.Q</Footer>
        </Layout>
    </Layout>

}

export default App;
