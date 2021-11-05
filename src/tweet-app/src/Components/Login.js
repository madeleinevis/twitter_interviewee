import axios from "axios";
import URL from "./URL";

function Login() {
    function handleSubmit(e) {
        let formData = new FormData();
        formData.append('username', e.target.form.username.value);
        formData.append('password', e.target.form.password.value);
        axios.post(`${URL}/login`, formData)
            .then(response => {
                console.log("response", response);
                sessionStorage.setItem('user', e.target.form.username.value);
                window.location.href='/#/dashboard';
            })
            .catch(function(error){
                if(error.response){
                    console.log(error.response.status);
                }
            })
    }
    return <div className="App">
        <form className="form">
            <div className="input-group">
                <label htmlFor="username">Username</label>
                <input type="text" id="username" name="username" placeholder="Your Username" />
            </div>
            <div className="input-group">
                <label htmlFor="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Your Password"/>
            </div>
            <button type="button" className="primary" onClick={handleSubmit}>Login</button>
        </form>
    </div>;
}

export default Login;