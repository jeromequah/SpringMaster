// AdminDrawerForm.js

import {Button, Col, Drawer, Form, Input, Row, Spin} from 'antd';

import {LoadingOutlined} from "@ant-design/icons";

// API Function
import {createLock} from "./client";

// Tracking State
import {useState} from 'react';

// Notifications
import {successNotification, errorNotification} from "./Notification";

const antIcon = <LoadingOutlined style={{ fontSize: 24 }} spin />;

function LockDrawerForm({showDrawer, setShowDrawer, fetchLocks}) {
    // Close the drawer
    const onCLose = () => setShowDrawer(false);
    // States after adding
    const [submitting, setSubmitting] = useState(false);

    const onFinish = lock => {
        setSubmitting(true);
        console.log(JSON.stringify(lock, null, 2))
        createLock(lock) // execute createAdmin API
            .then(() => {
                console.log("Lock Successfully Added!")
                onCLose(); // Close Drawer
                successNotification( // Success Noti
                    "Lock Successfully Added!",
                    `${lock.lockNickName} was added!`
                    )
                fetchLocks(); // Refresh Table
            }).catch(err => {
                console.log(err)
                err.response.json().then(res => {
                    console.log(res);
                    errorNotification(
                        "Create Lock Failed!",
                        `${res.message} [${res.status}] [${res.error}]`,
                        "bottomLeft")
                })
            }).finally(() => {
                setSubmitting(false);
        })
    };

    const onFinishFailed = errorInfo => {
        alert(JSON.stringify(errorInfo, null, 2));
    };

    return <Drawer
        title="Create new Lock"
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
                        name="lockNickName"
                        label="Lock Nick Name"
                        rules={[{required: true, message: 'Please enter Lock Nick Name'}]}
                    >
                        <Input placeholder="Please enter Lock Nick Name"/>
                    </Form.Item>
                </Col>
                <Col span={12}>
                    <Form.Item
                        name="Lock Name"
                        label="lockName"
                        rules={[{required: true, message: 'Please enter Lock Name'}]}
                    >
                        <Input placeholder="Please enter Lock Name"/>
                    </Form.Item>
                </Col>
            </Row>
            <Row gutter={16}>
                <Col span={12}>
                    <Form.Item
                        name="lockMacAddress"
                        label="MAC Address"
                        rules={[{required: true, message: 'Please input MAC Address'}]}
                    >
                        <Input placeholder="Please input MAC Address"/>
                    </Form.Item>
                </Col>

                <Col span={12}>
                    <Form.Item
                        name="lockUUID"
                        label="UUID"
                        rules={[{required: true, message: 'Please input UUID'}]}
                    >
                        <Input placeholder="Please input UUID"/>
                    </Form.Item>
                </Col>

                <Col span={12}>
                    <Form.Item
                        name="lockAESKey"
                        label="AES Key"
                        rules={[{required: true, message: 'Please input Encryption Key'}]}
                    >
                        <Input placeholder="Please input Encryption Key"/>
                    </Form.Item>
                </Col>

                <Col span={12}>
                    <Form.Item
                        name="lockPassword"
                        label="Password"
                        rules={[{required: true, message: 'Please input Password'}]}
                    >
                        <Input placeholder="Please input Password"/>
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
            <Row>
                {submitting && <Spin indicator = {antIcon}/>}
            </Row>
        </Form>
    </Drawer>
}

export default LockDrawerForm;