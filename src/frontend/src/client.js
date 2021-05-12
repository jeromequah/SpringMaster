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