import React, { useState } from 'react';

const TopBar: React.FC = () => {
  const [school, setSchool] = useState('');

  return (
    <>
      <div className=" fixed left-1/2 -translate-x-1/2 w-full bg-amber-200 flex flex-row justify-between pr-8 pl-8">
        <div className="flex flex-row justify-center items-center">
          {!school && <select></select>}
          {school && <div>{school}</div>}
          <div>icon</div>
          <div>{school}</div>
        </div>

        <div>
          123
          <avater></avater>
        </div>
      </div>
    </>
  );
};

export default TopBar;
