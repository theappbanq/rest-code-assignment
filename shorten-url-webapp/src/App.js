import React, {Component} from 'react';
import {Segment} from 'semantic-ui-react'
import './App.css';
import UrlInputBox from "./components/UrlInputBox";
import UrlTable from "./components/UrlTable";

import {getUrls, addUrl, deleteUrl} from './api'

import 'semantic-ui-css/semantic.css'

class App extends Component {


    constructor(props) {
        super(props)

        this.state = {
            urls: []
        }
    }

    componentDidMount() {
        this.loadUrls()
    }

    loadUrls() {
        getUrls().then((res) => {
            console.log(res)
            this.setState({urls: res.data})
        })
    }

    handleDelete(id) {
        console.log('delete', id)
        deleteUrl(id).then(() => this.loadUrls())
    }

    handleAdd(url) {
        console.log('add', url)
        addUrl(url).then(() => this.loadUrls())
    }

    render() {
        const {urls} = this.state

        return (
            <div className="App">
                <Segment>
                    <UrlInputBox addFunction={(url) => this.handleAdd(url)}/>
                    <UrlTable items={urls} deleteFunction={(id) => this.handleDelete(id)}/>
                </Segment>
            </div>
        );
    }
}

export default App;
