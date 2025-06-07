import axios from 'axios';
import usuarioService from '../services/usuarioService';

jest.mock('axios');
const mockedAxios = axios as jest.Mocked<typeof axios>;

describe('usuarioService', () => {
  it('register llama a /auth/register', async () => {
    mockedAxios.post.mockResolvedValue({ data: {} });
    await usuarioService.register({ email: 'a@a.com', password: '123' });
    expect(mockedAxios.post).toHaveBeenCalledWith('/auth/register', { email: 'a@a.com', password: '123' });
  });

  it('login guarda el token en localStorage', async () => {
    mockedAxios.post.mockResolvedValue({ data: { token: 'abc' } });
    await usuarioService.login({ email: 'a@a.com', password: '123' });
    expect(localStorage.getItem('token')).toBe('abc');
  });
});
