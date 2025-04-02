interface showCardProps {
  nickname: string;
  avatar: string;
  tag: string[];
  content: string;
  likeNumber: number;
  commentNumber: number;
}

// 这里参考知乎的布局
const showCard = () => {
  return (
    <>
      <div className="flex flex-col w-88 bg-amber-50 p-1">
        <hr />
        <div className="flex flex-row gap-2 h-12 items-center">
          <div>头像</div>
          <div className="text-2xl">名称</div>
          <div>标签</div>
        </div>
        <div className="text-2xl">标题</div>
        <div>12345</div>
      </div>
    </>
  );
};

export default showCard;
