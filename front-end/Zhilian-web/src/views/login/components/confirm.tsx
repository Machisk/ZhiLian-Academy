import { useNavigate } from 'react-router';
import { Checkbox } from '@/components/ui/checkbox';
import { Label } from '@/components/ui/label';
import { useState } from 'react';
import { RainbowButton } from '@/components/magicui/rainbow-button';
import { AnimatedShinyText } from '@/components/magicui/animated-shiny-text';
import { ArrowRightIcon } from 'lucide-react';
import { cn } from '@/lib/utils';
import { Ripple } from '@/components/magicui/ripple';

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
        <div className="relative flex h-[500px] w-full flex-col items-center justify-center overflow-hidden rounded-lg border bg-background">
          <p className="z-10 whitespace-pre-wrap text-center text-5xl font-medium tracking-tighter text-white">
            Ripple
          </p>
          <Ripple />
        </div>
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
        <div className="z-10 flex min-h-64 items-center justify-center">
          <div
            className={cn(
              'group rounded-full border border-black/5 bg-neutral-100 text-base text-white transition-all ease-in hover:cursor-pointer hover:bg-neutral-200 dark:border-white/5 dark:bg-neutral-900 dark:hover:bg-neutral-800'
            )}
          >
            <AnimatedShinyText className="inline-flex items-center justify-center px-4 py-1 transition ease-out hover:text-neutral-600 hover:duration-300 hover:dark:text-neutral-400">
              <span>✨ Get Start!</span>
              <ArrowRightIcon className="ml-1 size-3 transition-transform duration-300 ease-in-out group-hover:translate-x-0.5" />
            </AnimatedShinyText>
          </div>
        </div>
      </div>
    </>
  );
};

export default Confirm;
