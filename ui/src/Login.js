import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import { Link } from 'react-router-dom';

import './Login.css';
import UserRegistration from './UserRegistration.js';

function Login() {

  const [showPass, setShowPass] = useState(false);
  const passVis = () => {
    setShowPass(!showPass);
  };

  const userReg = () => {
    return (
      <Router>
        <Switch>
          {/* Other routes */}
          <Route path="/new" component={UserRegistration} />
        </Switch>
      </Router>
    );
  };

  return (
    <div className="Login">
      <header className="Login-header">Login Page</header>
      <h1>Please provide the login information for your Media Library Account.</h1>

      <div className="Log">
        <div >
          <label for="login">Login </label>
          <input type="email" name="login" id="login" placeholder="janedoe@example.com" required/>
        </div>
        <div>
          <label for="password">Password </label>
          <input type={showPass ? "text" : "password"} name="password" id="password" placeholder="Enter Password" required />
          <input type="checkbox" checked={showPass} onChange={passVis} />Show Password?
        </div>
        Don't have an account?<Link to="/new"> Create one!</Link>
        <button type="submit">Submit</button>
        <button type="cancel">Cancel</button>
      </div>
    </div>

    
  );
}

export default Login;
