import { useState, useEffect } from 'react';

export function useAuth() {
  const [token, setToken] = useState<string | null>(() => localStorage.getItem('token'));
  const [isAuthenticated, setIsAuthenticated] = useState(!!token);
  const [userId, setUserId] = useState<string | null>(() => localStorage.getItem('userId'));

  useEffect(() => {
    const storedToken = localStorage.getItem('token');
    const storedUserId = localStorage.getItem('userId');
    setToken(storedToken);
    setUserId(storedUserId);
    setIsAuthenticated(!!storedToken);
  }, []);

  useEffect(() => {
    setIsAuthenticated(!!token);
    setUserId(localStorage.getItem('userId'));
  }, [token]);

  const login = (jwt: string) => {
    localStorage.setItem('token', jwt);
    setToken(jwt);
    setIsAuthenticated(true);
    const storedUserId = localStorage.getItem('userId');
    setUserId(storedUserId);
  };

  const logout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('userId');
    localStorage.removeItem('nombreUsuario');
    setToken(null);
    setIsAuthenticated(false);
    setUserId(null);
  };

  return { token, isAuthenticated, login, logout, userId };
}
