import { create } from 'zustand';
import { persist } from 'zustand/middleware';

interface UserState {
  token: string | null;
  username: string | null;
  role: string | null;
  setToken: (token: string) => void;
  setUsername: (username: string) => void;
  setRole: (role: string) => void;
  clearUserInfo: () => void;
}

const useUserInfoStore = create<UserState>((set) => ({
  token: null,
  username: null,
  role: null,
  setToken: (token) => set({ token }),
  setUsername: (username) => set({ username }),
  setRole: (role) => set({ role }),
  clearUserInfo: () => set({ token: null, username: null, role: null })
}));

export default useUserInfoStore;
