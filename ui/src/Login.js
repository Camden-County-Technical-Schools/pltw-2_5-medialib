import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './Login.css';

function Login() {
  const [showPass, setShowPass] = useState(false);

  const passVis = () => {
    setShowPass(!showPass);
  };

  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent default form submission behavior
    // Handle form submission logic here
  };

  return (
    <div>
      <header >Login Page</header>
      <h1>Please provide the login information for your Media Library Account.</h1>
      <form>
        <div>
          <label htmlFor="login">Login </label>
          <input type="email" name="login" id="login" placeholder="janedoe@example.com" required />
        </div>
        <div>
          <label htmlFor="password">Password </label>
          <input
            type={showPass ? 'text' : 'password'}
            name="password"
            id="password"
            placeholder="Enter Password"
            required
          />
          <input type="checkbox" checked={showPass} onChange={passVis} />Show Password?
        </div>
        {/*<p>Don't have an account? <Link to="/register">Create one now!</Link></p>*/}
        <button type="submit">Submit</button>
        <button type="reset">Cancel</button>
      </form>
    </div>
  );
}

export default Login;
