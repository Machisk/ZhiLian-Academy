import { MagicCard } from '@/components/magicui/magic-card';
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle
} from '@/components/ui/card';
import { Label } from '@/components/ui/label';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import { useNavigate } from 'react-router';
import { useState } from 'react';
import { BorderBeam } from '@/components/magicui/border-beam';

const Login = () => {
  const nav = useNavigate();

  interface UserInfo {
    username: string;
    password: string;
  }

  const [userInfo, setUserInfo] = useState<UserInfo>({ username: '', password: '' });

  const logIn = () => {};

  const handelRegister = () => {
    nav('/login/register');
  };
  const handelLogin = () => {
    window.localStorage.setItem('token', '123');
    console.log(userInfo);
    logIn();
    nav('/');
  };

  return (
    <div>
      <Card className="relative overflow-hidden w-[500px] h-auto p-0">
        <MagicCard className="w-full h-auto p-10" gradientColor={'#D9D9D955'}>
          <CardHeader>
            <CardTitle className="text-2xl p-2">登录</CardTitle>
            <CardDescription className="text-1xl pb-2">
              Enter your credentials to access your account
            </CardDescription>
          </CardHeader>
          <CardContent>
            <form>
              <div className="grid gap-4">
                <div className="grid gap-2 text-2xl">
                  <Label htmlFor="username" className=" text-2xl">
                    username
                  </Label>
                  <Input
                    id="username"
                    type="username"
                    placeholder="name"
                    value={userInfo.username}
                    onChange={(e) => {
                      setUserInfo({
                        ...userInfo,
                        username: e.target.value
                      });
                    }}
                  />
                </div>
                <div className="grid gap-2">
                  <Label htmlFor="password" className=" text-2xl ">
                    Password
                  </Label>
                  <Input
                    id="password"
                    type="password"
                    value={userInfo.password}
                    onChange={(e) => {
                      setUserInfo({
                        ...userInfo,
                        password: e.target.value
                      });
                    }}
                  />
                </div>
              </div>
            </form>
          </CardContent>
          <CardFooter>
            <div className="pt-3 flex w-full  justify-around">
              <Button className="w-1/3" onClick={handelRegister}>
                注册
              </Button>
              <Button className="w-1/3" onClick={handelLogin}>
                登录
              </Button>
            </div>
          </CardFooter>
        </MagicCard>
        <BorderBeam
          duration={6}
          size={400}
          className="from-transparent via-green-500 to-transparent"
        />
        <BorderBeam
          duration={6}
          delay={3}
          size={400}
          className="from-transparent via-green-500 to-transparent"
        />
      </Card>
    </div>
  );
};

export default Login;
