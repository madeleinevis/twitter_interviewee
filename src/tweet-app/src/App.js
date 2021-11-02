// import logo from './logo.svg';
import './App.css';
import {Route, BrowserRouter as Router, Switch} from "react-router-dom";
import {Fragment} from "react";

import Login from './Components/Login';
import Dashboard from './Components/Dashboard';


const App = () => {
    return (
        <Fragment>
            <Router>
                <Switch>
                    <Route exact path="/login">
                        <Login/>
                    </Route>
                    <Route path="/dashboard">
                        <Dashboard />
                    </Route>
                </Switch>
            </Router>
        </Fragment>
    );
}
export default App;
