import React , { useState } from 'react';
import { Link } from 'react-router-dom';


function UserRegistration() {

    const [showPass, setShowPass] = useState(false);
    const passVis = () => {
        setShowPass(!showPass);
    };

    return(
      <div>
        <header>Registration Page</header>
        <h1>Please fill in the following fields to register a new Media Library Account.</h1>
        <div className="Log">
          <div>
            <label for="login">Email </label>
            <input type="email" name="login" id="login" placeholder="janedoe@example.com" required />
          </div>
          <div>
            <label for="first-name">First Name </label>
            <input type="email" name="first-name" id="first-name" placeholder="Jane" required />
          </div>
          <div>
            <label for="last-name">Last Name </label>
            <input type="email" name="last-name" id="last-name" placeholder="Doe"  />
          </div>
          <div>
            <label for="password">Password </label>
            <input type={showPass ? "text" : "password"} name="password" id="password" placeholder="Enter Password" required />
            <input type="checkbox" checked={showPass} onChange={passVis} />Show Password?
          </div>
          <div>
            <label for="q1">User Question Selection #1</label>
            <select id="q1" name="q1">
                <option value="op1"></option>
            </select>
          </div>
          <p>Have an account? <Link to="/" class="link">Login now!</Link></p>
          <button type="submit">Submit</button>
          <button type="reset">Cancel</button>
        </div>
    </div>
    );
}


export default UserRegistration;
