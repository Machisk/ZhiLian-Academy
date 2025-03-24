import { MagicCard } from './components/magicui/magic-card';
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle
} from '@/components/ui/card';
import { Label } from './components/ui/label';
import { Button } from './components/ui/button';
import { Input } from './components/ui/input';
import { useNavigate } from 'react-router';
import { useState } from 'react';
import { BorderBeam } from './components/magicui/border-beam';

const Login = () => {
  const nav = useNavigate();

  interface UserInfo {
    username: string;
    password: string;
  }

  const [userInfo, setUserInfo] = useState<UserInfo>({ username: '', password: '' });

  const logIn = () => {};

  const handelRegister = () => {
    nav('/register');
  };
  const handelLogin = () => {
    console.log(userInfo);
    logIn();
    nav('/');
  };

  return (
    <div>
      <Card className="relative overflow-hidden w-2/3 h-[300px] p-0">
        <MagicCard className="w-full h-[300px] p-10" gradientColor={'#D9D9D955'}>
          <CardHeader>
            <CardTitle>Login</CardTitle>
            <CardDescription>Enter your credentials to access your account</CardDescription>
          </CardHeader>
          <CardContent>
            <form>
              <div className="grid gap-4">
                <div className="grid gap-2">
                  <Label htmlFor="username">username</Label>
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
                  <Label htmlFor="password">Password</Label>
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
            <Button onClick={handelRegister}>注册</Button>
            <Button onClick={handelLogin}>登录</Button>
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
