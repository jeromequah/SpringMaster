// Contains all functions to perform HTTP requests to backend

import fetch from 'unfetch';

const checkStatus = response => {
    if (response.ok) {
    return response;
}
    // convert non-2xx HTTP responses into errors:
    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);
}

export const getAllAdmin = () =>
    fetch('api/v1/admins/allAdmin')
    .then(checkStatus);

export const createAdmin = admin =>
    fetch('api/v1/admins/createAdmin', {
        headers:{
            'Content-Type':'application/json'
        },
        method: 'POST',
        body: JSON.stringify(admin)
    })
        .then(checkStatus);

export const deleteAdmin = adminId =>
    fetch(`api/v1/admins/delete/${adminId}`, {
        method: 'DELETE'
    }).then(checkStatus);

export const getAllLock = () =>
    fetch ('api/v1/locks/allLock')
        .then(checkStatus);

export const createLock = lock =>
    fetch('api/v1/locks/createLock', {
        headers:{
            'Content-Type':'application/json'
        },
        method: 'POST',
        body: JSON.stringify(lock)
    })
        .then(checkStatus);

export const deleteLock = lockId =>
    fetch(`api/v1/locks/delete/${lockId}`, {
        method: 'DELETE'
    }).then(checkStatus);