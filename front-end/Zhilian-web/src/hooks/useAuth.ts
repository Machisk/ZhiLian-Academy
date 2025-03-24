import useUserInfoStore from '@/store/useUserInfoStore';
import { BlobOptions } from 'buffer';

const useAuth = () => {
  const userInfoStore = useUserInfoStore();

  const setToken = (token: string) => {
    window.localStorage.setItem('token', token);
  };

  const isAuth = (): boolean => {
    if (userInfoStore.token) return true;
    if (window.localStorage.getItem('token')) {
      return true;
    }
    return false;
  };

  return { isAuth, setToken };
};

export default useAuth;
