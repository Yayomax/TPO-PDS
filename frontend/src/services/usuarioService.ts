import api from './api';

const usuarioService = {
  registrar: (usuario: any) => api.post('/usuarios/register', usuario),
  login: (credenciales: any) => api.post('/usuarios/login', credenciales),
  listarTodos: () => api.get('/usuarios'),
};

export default usuarioService;
