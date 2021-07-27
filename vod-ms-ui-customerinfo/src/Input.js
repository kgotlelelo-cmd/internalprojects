import React from 'react';


export default class Form extends React.Component {


    constructor(props) {
        super(props);
        this.state = { 
            value: '',
            data:[]
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmint = this.handleSubmint.bind(this);
    }

    handleChange(event) {
        this.setState({
            value: event.target.value
        });
    }

    handleSubmint(event) {
        alert("Phone number was submitted: " + this.state.value);
        var link = 'http://localhost:3030/customer/'+this.state.value;
        // console.log(link);
        fetch(link)
            .then(res=>res.json())
            .then(result =>{
                this.setState(
                    {data:result}
                )
            }).catch(err=>console.log(err))
        event.preventDefault();
    }

    render() {
        let value = []
        let displayValue = []
        return (
            <form onSubmit={this.handleSubmint}>
                <label>
                    <input type="text" value={this.state.value} onChange={this.handleChange} maxLength="11" placeholder="27798122613" />
                </label>
                <input type="submit" value="submit" />
                <p>
                    {JSON.stringify(this.state.data.firstname)}
                </p>
                <p>
                    {JSON.stringify(this.state.data.lastname)}
                </p>
                <p>
                    {/* {JSON.stringify(this.state.data.billingaddress)}  */}
                    {this.state.data.billingaddress && console.log(this.state.data.billingaddress.map((item, index) => {
                        value.push(item)
                        return item
                    }))
                    
                    }
                    <ul>
                        {
                            (value.map((item, index ) => {
                                return Object.entries(item).map(([key, value])=>{
                                    return  (<li>{key}:{item[key]}</li>)
                                })
                            }))
                        }

                        
                    </ul>
                </p>
            </form>
        );
    }
}