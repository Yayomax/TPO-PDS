import { render, fireEvent, screen } from '@testing-library/react';
import LoginForm from '../components/LoginForm';
import usuarioService from '../services/usuarioService';

// Mock react-router-dom to avoid requiring the actual library during tests
jest.mock(
  'react-router-dom',
  () => ({
    useNavigate: () => jest.fn(),
  }),
  { virtual: true }
);

jest.mock('../services/usuarioService');
const mockLoginHook = jest.fn();
jest.mock('../services/useAuth', () => ({
  useAuth: () => ({ login: mockLoginHook }),
}));

describe('LoginForm', () => {
  it('envía login y muestra mensaje', async () => {
    (usuarioService.login as jest.Mock).mockResolvedValue({ token: 'tok', id: 2 });
    render(<LoginForm />);
    fireEvent.change(screen.getByPlaceholderText('Email'), { target: { value: 'a@a.com' } });
    fireEvent.change(screen.getByPlaceholderText('Contraseña'), { target: { value: '123' } });
    fireEvent.click(screen.getByText('Ingresar'));
    expect(await screen.findByText(/Login exitoso|Error en el login/)).toBeInTheDocument();
    expect(mockLoginHook).toHaveBeenCalledWith('tok', '2');
  });
});
