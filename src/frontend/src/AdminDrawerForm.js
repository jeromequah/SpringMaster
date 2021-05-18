// AdminDrawerForm.js
import {Button, Col, Drawer, Form, Input, Row} from 'antd';

// API Function
import {createAdmin} from "./client";

function AdminDrawerForm({showDrawer, setShowDrawer}) {
    const onCLose = () => setShowDrawer(false);

    const onFinish = admin => {
        console.log(JSON.stringify(admin, null, 2))
        createAdmin(admin)
            .then(() => {
                console.log("Admin Successfully Added!")
            }).catch(err => {
            console.log(err)
        })
    };

    const onFinishFailed = errorInfo => {
        alert(JSON.stringify(errorInfo, null, 2));
    };

    return <Drawer
        title="Create new Admin"
        width={720}
        onClose={onCLose}
        visible={showDrawer}
        bodyStyle={{paddingBottom: 80}}
        footer={
            <div
                style={{
                    textAlign: 'right',
                }}
            >
                <Button onClick={onCLose} style={{marginRight: 8}}>
                    Cancel
                </Button>
            </div>
        }
    >
        <Form layout="vertical"
              onFinishFailed={onFinishFailed}
              onFinish={onFinish}
              hideRequiredMark>
            <Row gutter={16}>
                <Col span={12}>
                    <Form.Item
                        name="fullName"
                        label="Full Name"
                        rules={[{required: true, message: 'Please enter Admin Full Name'}]}
                    >
                        <Input placeholder="Please enter Admin Full Name"/>
                    </Form.Item>
                </Col>
                <Col span={12}>
                    <Form.Item
                        name="email"
                        label="Email"
                        rules={[{required: true, message: 'Please enter Admin email'}]}
                    >
                        <Input placeholder="Please enter Admin email"/>
                    </Form.Item>
                </Col>
            </Row>
            <Row gutter={16}>
                <Col span={12}>
                    <Form.Item
                        name="dob"
                        label="Date of Birth"
                        rules={[{required: true, message: 'Please input Date of Birth'}]}
                    >
                        <Input placeholder="Please Input Date of Birth in 'YYYY-MM-DD' Format"/>
                    </Form.Item>
                </Col>

                <Col span={12}>
                    <Form.Item
                        name="mobileNumber"
                        label="Mobile Number"
                        rules={[{required: true, message: 'Please input Mobile Number'}]}
                    >
                        <Input placeholder="Please Input Mobile Number"/>
                    </Form.Item>
                </Col>

                <Col span={12}>
                    <Form.Item
                        name="password"
                        label="Password"
                        rules={[{required: true, message: 'Please input Password'}]}
                    >
                        <Input placeholder="Please Input Password"/>
                    </Form.Item>
                </Col>
            </Row>
            <Row>
                <Col span={12}>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">
                            Submit
                        </Button>
                    </Form.Item>
                </Col>
            </Row>
        </Form>
    </Drawer>
}

export default AdminDrawerForm;