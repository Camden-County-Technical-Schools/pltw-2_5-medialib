import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './Login.css'

function Media() {
    const [showPass, setShowPass] = useState(false);

    const passVis = () => {
        setShowPass(!showPass);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        
    };

    return (
        <div>
            <header>Media Library</header>
            <h1>Welcome to your Media Library!</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label for="login">Login </label>
                    <input type="email" name="login" id="login" placeholder="janedoe@example.com" required />
                </div>
                <div>
                    <label for="password">Password </label>
                    <input
                        type={showPass ? 'text' : 'password'}
                        name="password"
                        id="password"
                        placeholder="Enter Password"
                        required
                    />
                    <input type="checkbox" checked={showPass} onChange={passVis} /> Show Password?
                </div>
                <p>Don't have an account? <Link to="/register" class="Link">Create one now!</Link></p>
                <button type="submit">Submit</button>
                <button type="reset">Cancel</button>
            </form>
        </div>
    );
}

export default Media;
