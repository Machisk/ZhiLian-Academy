import { create } from 'zustand';
// import { persist } from 'zustand/middleware';

interface UserState {
  token: string | null;
  username: string | null;
  role: string | null;
  avatar: string | null;
  school: string | null;
  major: string | null;
  grade: string | null;
  // 个人简介
  bio: string | null;
  setToken: (token: string) => void;
  setUsername: (username: string) => void;
  setRole: (role: string) => void;
  setAvatar: (avatar: string) => void;
  setSchool: (school: string) => void;
  setMajor: (major: string) => void;
  setGrade: (grade: string) => void;
  setBio: (bio: string) => void;
  clearUserInfo: () => void;
}

const useUserInfoStore = create<UserState>((set) => ({
  token: null,
  username: null,
  role: null,
  avatar: null,
  school: null,
  major: null,
  grade: null,
  bio: null,
  setToken: (token) => set({ token }),
  setUsername: (username) => set({ username }),
  setRole: (role) => set({ role }),
  setAvatar: (avatar) => set({ avatar }),
  setSchool: (school) => set({ school }),
  setMajor: (major) => set({ major }),
  setGrade: (grade) => set({ grade }),
  setBio: (bio) => set({ bio }),
  clearUserInfo: () => set({ token: null, username: null, role: null, avatar: null, school: null, major: null, grade: null, bio: null })
}));

export default useUserInfoStore;
