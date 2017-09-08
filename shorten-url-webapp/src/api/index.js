import {get,post, del} from './utils'


const SERVER_URL = "/api"

export function getUrls() {
    return get(SERVER_URL)
}

export function addUrl(url) {
    return post(SERVER_URL, url)
}

export function deleteUrl(id) {
    return del(SERVER_URL+ '/'+id)
}

