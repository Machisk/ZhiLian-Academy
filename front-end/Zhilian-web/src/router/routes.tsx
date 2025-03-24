import { Button } from '@/components/ui/button';
import Unconnection from '@/views/404';
import LogInView from '@/views/login';
import Confirm from '@/views/login/components/confirm';
import Login from '@/views/login/components/login';
import MainPageLayout from '@/views/main';
import TopBar from '@/views/main/topbar';
import { RouteObject } from 'react-router';
import { Navigate } from 'react-router';

const routes: RouteObject[] = [
  {
    path: '/',
    element: <MainPageLayout></MainPageLayout>,
    children: [
      {
        index: true,
        element: <TopBar />
      }
    ]
  },
  {
    path: '/login',
    element: <LogInView></LogInView>,
    children: [
      { index: true, element: <Login /> },
      { path: 'confirm', element: <Confirm /> }
    ]
  },
  { path: '/404', element: <Unconnection></Unconnection> },
  { path: '*', element: <Navigate to="/404"></Navigate> }
];

export default routes;
