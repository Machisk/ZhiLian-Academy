import { RouterProvider } from 'react-router';
import router from './router/index';
import MainPage from './views/main';

function App() {
  return (
    <>
      <RouterProvider router={router}></RouterProvider>
    </>
  );
}

export default App;
