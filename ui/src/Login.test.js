import { render, screen } from '@testing-library/react';
import Login from '/workspace/pltw-2_5-medialib/ui/src/Login.js';

test('renders app page', () => {
  render(
      <Login />
  );

  // Example assertion: assuming Login component renders some text like "Login Page"
  const linkElement = screen.getByText(/login page/i);
  expect(linkElement).toBeInTheDocument();
});
