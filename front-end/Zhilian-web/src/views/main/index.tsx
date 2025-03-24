import React, { useEffect, useState } from 'react';
import topBar from './topbar';
import { Outlet, useSearchParams } from 'react-router';
import Login from '../login/components/login';
import Confirm from '../login/components/confirm';
import Ablitity from './content/ablitity';
import Help from './content/help';
import Commerce from './content/commerce';

const MainPageLayout: React.FC = () => {
  const [searchParams, setSearchParams] = useSearchParams();
  const [roleState, setRoleState] = useState({
    ablitity: false,
    help: false,
    com: false
  });

  const [showDefault, setShowDefault] = useState(false);

  useEffect(() => {
    const params = {};
    for (const [key, value] of searchParams.entries()) {
      params[key] = value === 'true';
    }

    // 如果params为空对象，使用默认状态
    if (Object.keys(params).length === 0) {
      setRoleState({
        ablitity: false,
        help: false,
        com: false
      });
      setShowDefault(true);
    } else {
      setRoleState(params as unknown as typeof roleState);
      setShowDefault(false);
    }

    console.log(params);
  }, [searchParams]);

  return (
    <>
      <div>
        {showDefault && <Help></Help>}
        {roleState.ablitity && <Ablitity></Ablitity>}
        {roleState.help && <Help></Help>}
        {roleState.com && <Commerce></Commerce>}
        <Login></Login>
        <Confirm></Confirm>
        <Outlet></Outlet>
      </div>
    </>
  );
};

export default MainPageLayout;
