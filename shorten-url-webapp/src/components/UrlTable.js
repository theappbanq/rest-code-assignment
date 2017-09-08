import React, {Component} from 'react'
import {Table, Button} from 'semantic-ui-react'
import PropTypes from 'prop-types'

export default class UrlTable extends Component {
    static propTypes = {
        items: PropTypes.array,
        deleteFunction: PropTypes.func
    }

    render() {
        const {items, deleteFunction} = this.props
/* "id": 2,
        "orgUrl": "http://google.com/a",
        "shortenUrl": "http://localhost:8080/r/2"
        */
        return (
            <Table>
            <Table.Header>
                <Table.Row>
                    <Table.HeaderCell>#</Table.HeaderCell>
                    <Table.HeaderCell>Url</Table.HeaderCell>
                    <Table.HeaderCell>Short Url</Table.HeaderCell>
                    <Table.HeaderCell> </Table.HeaderCell>
                </Table.Row>
            </Table.Header>

            <Table.Body>
                {items &&
                items.map((c, i) => {
                    return (
                        <Table.Row key={i}>
                            <Table.Cell width="1">{i + 1}</Table.Cell>
                            <Table.Cell width="5">{c.orgUrl}</Table.Cell>
                            <Table.Cell width="4"><a href={c.shortenUrl} target="_blank">Short URL</a></Table.Cell>
                            <Table.Cell width="2">
                                <Button icon={'remove'} onClick={() => deleteFunction(c.id)}/>
                            </Table.Cell>
                        </Table.Row>)
                })

                }
            </Table.Body>

        </Table>)
    }
}

