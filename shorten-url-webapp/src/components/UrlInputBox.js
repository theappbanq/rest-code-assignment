import React, {Component} from 'react'
import {Segment, Button, Input, Header} from 'semantic-ui-react'
import PropTypes from 'prop-types'


export default class UrlInputBox extends Component {
    static propTypes = {
        addFunction: PropTypes.func
    }

    constructor(props) {
        super(props)
        this.state = {
            url: ''
        }
    }

    handleInputChange(e) {
        this.setState({url: e.target.value})
    }

    render() {
        const {addFunction} = this.props

        return (
            <Segment>
                <Header>
                    Simplify your links
                </Header>
                <Input fluid name="name" placeholder={"You origin url"} type="text"
                       onChange={(e) => this.handleInputChange(e)}>
                    <input />
                    <Button icon={'add'} label={'shorten url'} onClick={() => addFunction(this.state.url)}/>
                </Input>
            </Segment>
        )
    }
}