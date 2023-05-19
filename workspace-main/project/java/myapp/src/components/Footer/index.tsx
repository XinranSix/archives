import {GithubOutlined} from '@ant-design/icons';
import {DefaultFooter} from '@ant-design/pro-components';
import {PLANET_LINK} from "@/constants";
// import {useIntl} from 'umi';

const Footer: React.FC = () => {
  // const intl = useIntl();
  const defaultMessage = '冷梦出品';
  const currentYear = new Date().getFullYear();

  return (
    <DefaultFooter
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'planet',
          title: '知识星球',
          href: PLANET_LINK,
          blankTarget: true,
        },
        {
          key: 'codeNav',
          title: '编程导航',
          href: 'https://www.code-nav.cn',
          blankTarget: true,
        },
        {
          key: 'github',
          title: <><GithubOutlined/> 冷梦 GitHub</>,
          href: 'https://github.com/lemonsama123',
          blankTarget: true,
        },
      ]}
    />
  );
};

export default Footer;
