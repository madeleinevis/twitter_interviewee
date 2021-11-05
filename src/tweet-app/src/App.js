// import logo from './logo.svg';
import './App.css';
import {Route, Switch, Redirect, HashRouter} from "react-router-dom";
import {Fragment} from "react";

import Login from './Components/Login';
import Dashboard from './Components/Dashboard';


const App = () => {
    return (
        <Fragment>
            <HashRouter>
                <Switch>
                    <Route exact path="/">
                        <Redirect to={"/login"}/>
                    </Route>
                    <Route exact path="/login">
                        <Login/>
                    </Route>
                    <Route exact path="/dashboard">
                        <Dashboard />
                    </Route>
                </Switch>
            </HashRouter>
        </Fragment>
    );
}
export default App;
