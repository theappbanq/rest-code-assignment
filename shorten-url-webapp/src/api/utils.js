export default function requestWrapper (method) {
    return async function (url, data = null, params = {}) {
        if (method === 'GET') {
            // It's a GET response
            // GET doesn't have data
            params = data
            data = null
        }

        // Default params for fetch = method + (Content-Type)
        const defaults = {
            method,
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }


        if (data) {
            defaults.body = data
        }

        const paramsObj = {...defaults, headers: {...params, ...defaults.headers}}
        return fetch(url, paramsObj)
            .then(checkStatus)
            .then(parseJSON)
            .catch(err => {
                console.error(err)
            })
    }
}

// Checks response status in production env
function checkStatus (response) {
    const {status} = response
    if (status >= 200 && status < 300) {
        // Everything is ok
        return response
    } else if (status >= 300 && status < 400) {
        // 300 Multiple Choices
        // 301 - Moved Permanently,
        // 302 - Found, Moved Temporarily
        // 304 - not modified
        // 307 - Temporary Redirect
    } else if (status === 400) {
        // Probably is a validation error
        return response
    } else if (status === 403 || status === 401) {
        // 401 - Forbidden
        // 403 - Unauthorized

    } else if (status === 404) {
        // Not Found
        return response
    } else if (status >= 500) {
        // Server error
        return response
    }
}

/**
 // middlewares
 * 1. parse response
 * 2. add "ok" property to result
 * 3. return request result
 * @param  {Object} res - response from server
 * @return {Object} response result with "ok" property
 */
async function parseJSON (res) {
    let json
    try {
        json = await res.json()
    } catch (e) {
        return {data: {}, ok: false}
    }

    // Simplest validation ever, ahah :)
    if (!res.ok) {
        return {data: json, ok: false}
    }
    // ResultOK - is a function with side effects
    // It removes ok property from result object
    return {data: json, ok: true}
}

export const get = requestWrapper('GET')
export const post = requestWrapper('POST')
export const put = requestWrapper('PUT')
export const patch = requestWrapper('PATCH')
export const del = requestWrapper('DELETE')