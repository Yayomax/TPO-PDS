import { render, fireEvent, screen } from '@testing-library/react';
import RegisterForm from '../components/RegisterForm';
import usuarioService from '../services/usuarioService';

jest.mock('../services/usuarioService');

describe('RegisterForm', () => {
  it('envía registro y muestra mensaje', async () => {
    (usuarioService.register as jest.Mock).mockResolvedValue({});
    render(<RegisterForm />);
    fireEvent.change(screen.getByPlaceholderText('Nombre'), { target: { value: 'Test' } });
    fireEvent.change(screen.getByPlaceholderText('Email'), { target: { value: 'a@a.com' } });
    fireEvent.change(screen.getByPlaceholderText('Contraseña'), { target: { value: '123' } });
    fireEvent.click(screen.getByText('Registrarse'));
    expect(await screen.findByText(/Registro exitoso|Error en el registro/)).toBeInTheDocument();
  });
});
