import { useNavigate } from 'react-router';
import { Button } from './components/ui/button';
import { Checkbox } from './components/ui/checkbox';
import { Label } from './components/ui/label';
import { useState } from 'react';
import { RainbowButton } from './components/magicui/rainbow-button';

const Confirm = () => {
  const nav = useNavigate();

  const [interest, setInterest] = useState({
    ablitity: false,
    help: false,
    com: false
  });

  const handleCheckboxChange = (key: keyof typeof interest) => {
    return (checked: boolean) => {
      setInterest((prev) => ({
        ...prev,
        [key]: checked
      }));
    };
  };

  const handleClick = () => {
    let str = '';
    Object.keys(interest).forEach((key) => {
      str += `${key}=${interest[key]}&`;
    });
    str = str.slice(0, str.length - 1);
    nav(`/?${str}`);
  };

  return (
    <>
      <div>
        <div>对什么感兴趣？</div>
      </div>

      <div className="flex flex-row gap-3">
        <div className="flex items-center space-x-2">
          <Checkbox
            id="ablitity"
            checked={interest.ablitity}
            onCheckedChange={handleCheckboxChange('ablitity')}
          />
          <Label htmlFor="ablitity">我有特长！</Label>
        </div>
        <div className="flex items-center space-x-2">
          <Checkbox
            id="help"
            checked={interest.help}
            onCheckedChange={handleCheckboxChange('help')}
          />
          <Label htmlFor="help">需要帮助</Label>
        </div>
        <div className="flex items-center space-x-2">
          <Checkbox id="com" checked={interest.com} onCheckedChange={handleCheckboxChange('com')} />
          <Label htmlFor="com">我是商家！</Label>
        </div>
      </div>

      <div>
        <RainbowButton className=" text-black" onClick={handleClick}>
          快去看看
        </RainbowButton>
      </div>
    </>
  );
};

export default Confirm;
