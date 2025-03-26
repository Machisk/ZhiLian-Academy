import React, { useEffect, useState } from 'react';
import { Outlet, useSearchParams } from 'react-router';
import Login from '../login/components/login';
import Confirm from '../login/components/confirm';
import Ablitity from './content/ablitity';
import Help from './content/help';
import Commerce from './content/commerce';
import useNav from '@/hooks/useNav';
import useAuth from '@/hooks/useAuth';
import CustomDock from './dock/Dock';
import { BoxReveal } from '@/components/magicui/box-reveal';
import { Button } from '@/components/ui/button';
import MarqueeDemo from './content/demo';

const MainPageLayout: React.FC = () => {
  const nav = useNav();
  const auth = useAuth();

  const [searchParams, setSearchParams] = useSearchParams();
  const [roleState, setRoleState] = useState({
    ablitity: false,
    help: false,
    com: false
  });

  const [showDefault, setShowDefault] = useState(false);

  useEffect(() => {
    if (!auth.isAuth()) nav.navToWithoutAuth('/login');
  }, []);

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
      <div className="flex flex-col m-auto w-2/3 h-full p-2 bg-amber-100">
        <div className="size-full max-w-lg items-center justify-center overflow-hidden pt-8 p-3">
          <BoxReveal boxColor={'#5046e6'} duration={0.5}>
            <p className="text-[3.5rem] font-semibold">
              Title<span className="text-[#5046e6]">.</span>
            </p>
          </BoxReveal>

          <BoxReveal boxColor={'#5046e6'} duration={0.5}>
            <h2 className="mt-[.5rem] text-[1rem]">
              UI library for <span className="text-[#5046e6]">Design Engineers</span>
            </h2>
          </BoxReveal>

          <BoxReveal boxColor={'#5046e6'} duration={0.5}>
            <div className="mt-6">
              <p>
                -&gt; 20+ free and open-source animated components built with
                <span className="font-semibold text-[#5046e6]">React</span>,
                <span className="font-semibold text-[#5046e6]">Typescript</span>,
                <span className="font-semibold text-[#5046e6]">Tailwind CSS</span>, and
                <span className="font-semibold text-[#5046e6]">Motion</span>
                . <br />
                -&gt; 100% open-source, and customizable. <br />
              </p>
            </div>
          </BoxReveal>

          {/* <BoxReveal boxColor={'#5046e6'} duration={0.5}>
            <Button className="mt-[1.6rem] bg-[#5046e6]">Explore</Button>
          </BoxReveal> */}
        </div>
        <div className=" border-t-2 pt-2">
          <MarqueeDemo></MarqueeDemo>
        </div>
        se
        {showDefault && <Help></Help>}
        {roleState.ablitity && <Ablitity></Ablitity>}
        {roleState.help && <Help></Help>}
        {roleState.com && <Commerce></Commerce>}
        <Outlet></Outlet>
      </div>
      <CustomDock></CustomDock>
    </>
  );
};

export default MainPageLayout;
