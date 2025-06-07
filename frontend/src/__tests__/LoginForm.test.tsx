import { render, fireEvent, screen } from '@testing-library/react';
import LoginForm from '../components/LoginForm';
import usuarioService from '../services/usuarioService';

jest.mock('../services/usuarioService');

describe('LoginForm', () => {
  it('envía login y muestra mensaje', async () => {
    (usuarioService.login as jest.Mock).mockResolvedValue({});
    render(<LoginForm />);
    fireEvent.change(screen.getByPlaceholderText('Email'), { target: { value: 'a@a.com' } });
    fireEvent.change(screen.getByPlaceholderText('Contraseña'), { target: { value: '123' } });
    fireEvent.click(screen.getByText('Ingresar'));
    expect(await screen.findByText(/Login exitoso|Error en el login/)).toBeInTheDocument();
  });
});
