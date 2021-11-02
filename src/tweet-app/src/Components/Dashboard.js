import {Fragment, useState} from "react";
import axios from "axios";

import Tweets from './Tweets'
import PostTweet from "./PostTweet";

const Dashboard = () => {
    const [show, setShow] = useState(false);

    const [tweets, setTweets] = useState([]);

    if(sessionStorage.getItem('user') === null){
        window.location.href='/login';
    }

    function handleGet() {
        setShow(true);
        let formData = new FormData();
        formData.append('username', sessionStorage.getItem('user'));
        axios.post('http://localhost:8080/getAll', formData)
            .then(response => {
                console.log(response.data);
                setTweets(response.data);
            })
            .catch(function(error){
                if(error.response){
                    console.log(error.response.status);
                }
            })

    }

    function handlePost(){
        setShow(false);
    }

    function logOut(){
        sessionStorage.setItem('user', null);
        window.location.href='/login';
    }


    return (
        <Fragment>
            <div>
                <nav className="navbar navbar-expand-sm">
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav">
                            <li className="nav-item-menu">
                                <button onClick={handleGet}>Show Tweets</button>
                            </li>
                            <li className="nav-item-menu">
                                <button onClick={handlePost}>Post Tweet</button>
                            </li>
                            <li>
                                <button onClick={logOut}>Log Out</button>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
            { show ?
                <Tweets items={tweets}/>
            :
                <PostTweet/>
            }
        </Fragment>
    )
}
export default Dashboard;