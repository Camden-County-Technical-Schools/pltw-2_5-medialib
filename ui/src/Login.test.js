import { render, screen } from '@testing-library/react';
import Login from 'Login';

test('renders app page', () => {
  render(
      <Login />
  );

  // Example assertion: assuming Login component renders some text like "Login Page"
  const linkElement = screen.getByText(/login page/i);
  expect(linkElement).toBeInTheDocument();
});
