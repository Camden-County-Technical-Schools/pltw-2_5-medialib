import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './Login';
import UserRegistration from './UserRegistration';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/register" element={<UserRegistration />} />
            </Routes>
        </Router>
    );
}

export default App;
