import { renderHook, act } from '@testing-library/react';
import { useAuth } from '../services/useAuth';

describe('useAuth', () => {
  beforeEach(() => {
    localStorage.clear();
  });

  it('login y logout actualizan el estado', () => {
    const { result } = renderHook(() => useAuth());
    act(() => {
      result.current.login('token123', '1');
    });
    expect(result.current.isAuthenticated).toBe(true);
    expect(localStorage.getItem('token')).toBe('token123');
    expect(localStorage.getItem('userId')).toBe('1');
    act(() => {
      result.current.logout();
    });
    expect(result.current.isAuthenticated).toBe(false);
    expect(localStorage.getItem('token')).toBeNull();
    expect(localStorage.getItem('userId')).toBeNull();
  });
});
