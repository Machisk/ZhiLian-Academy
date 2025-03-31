import { Outlet } from 'react-router';

const LogInView = () => {
  return (
    <>
      <div className="w-full h-[100vh] flex flex-col items-center justify-center">
        <div className="pb-10 text-4xl">LoginView</div>
        <Outlet />
      </div>
    </>
  );
};

export default LogInView;
