import React, { useState } from 'react';

const TopBar: React.FC = () => {
  const [school, setSchool] = useState('还未设置学校');

  return (
    <>
      <div className=" fixed left-1/2 -translate-x-1/2 w-full">
        <p className="text-center">{school}</p>
      </div>
    </>
  );
};

export default TopBar;
