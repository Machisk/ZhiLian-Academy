import { useNavigate } from 'react-router';
import useAuth from './useAuth';
import { afterEach } from 'node:test';

// eslint-disable-next-line @typescript-eslint/no-unsafe-function-type
const useNav = (beforeNav?: Function, afterNav?: Function) => {
  const nav = useNavigate();
  const { isAuth } = useAuth();

  const navToWithoutAuth = (str: string) => {
    if (beforeNav && !beforeNav()) return;

    nav(str);

    if (afterNav) {
      afterNav();
    }
  };

  const navToWithAuth = (str: string) => {
    if (!isAuth) {
      nav('/login');
      return;
    }

    if (beforeNav && !beforeNav()) return;

    nav(str);

    if (afterNav) {
      afterNav();
    }
  };

  return {
    navToWithAuth,
    navToWithoutAuth
  };
};

export default useNav;
