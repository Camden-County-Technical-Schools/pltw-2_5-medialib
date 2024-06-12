import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function User({
  login,
  firstName,
  lastName,
  password,
  userQuestion,
  setLogin,
  setFirstName,
  setLastName,
  setPassword,
  setUserQuestion,
}) {
  return (
    <div>
      <div>
        <label htmlFor="login">Email </label>
        <input
          type="email"
          name="login"
          id="login"
          value={login}
          onChange={(e) => setLogin(e.target.value)}
          placeholder="janedoe@example.com"
          required
        />
      </div>
      <div>
        <label htmlFor="first-name">First Name </label>
        <input
          type="text"
          name="first-name"
          id="first-name"
          value={firstName}
          onChange={(e) => setFirstName(e.target.value)}
          placeholder="Jane"
          required
        />
      </div>
      <div>
        <label htmlFor="last-name">Last Name </label>
        <input
          type="text"
          name="last-name"
          id="last-name"
          value={lastName}
          onChange={(e) => setLastName(e.target.value)}
          placeholder="Doe"
        />
      </div>
      <div>
        <label htmlFor="user-question">User Question </label>
        <select>
          <option></option>
        </select>
      </div>
      <div>
        <label htmlFor="password">Password </label>
        <input
          type="password"
          name="password"
          id="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          placeholder="Enter Password"
          required
        />
      </div>
    </div>
  );
}

function UserRegistration() {
  const [login, setLogin] = useState('');
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [userQuestion, setUserQuestion] = useState('');
  const [showPass, setShowPass] = useState(false);
  const [error, setError] = useState('');

  const passVis = () => {
    setShowPass(!showPass);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (password !== confirmPassword) {
      setError("Passwords do not match");
      return;
    }

    const user = {
      login,
      firstName,
      lastName,
      password,
      userQuestion,
    };

    try {
      const response = await fetch('http://localhost:8080/api/users', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(user),
      });

      if (response.ok) {
        console.log('User registered successfully');
      } else {
        console.error('Failed to register user');
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <div>
      <header>Registration Page</header>
      <h1>Please fill in the following fields to register a new Media Library Account.</h1>
      <form className="Log" onSubmit={handleSubmit}>
        <User
          login={login}
          firstName={firstName}
          lastName={lastName}
          password={password}
          userQuestion={userQuestion}
          setLogin={setLogin}
          setFirstName={setFirstName}
          setLastName={setLastName}
          setPassword={setPassword}
          setUserQuestion={setUserQuestion}
        />
        <div>
          <label htmlFor="confirm-password">Confirm Password </label>
          <input
            type={showPass ? 'text' : 'password'}
            name="confirm-password"
            id="confirm-password"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            placeholder="Confirm Password"
            required
          />
          <input type="checkbox" checked={showPass} onChange={passVis} /> Show Password?
        </div>
        {error && <p class="Error">{error}</p>}
        <p>
          Have an account? <Link to="/" className="Link">Login now!</Link>
        </p>
        <button type="submit">Submit</button>
        <button type="reset" onClick={() => setError('')}>Cancel</button>
      </form>
    </div>
  );
}

export default UserRegistration;
