import axios from "axios";

axios.defaults.baseURL = "https://i5a403.p.ssafy.io/api/";

export default {
  methods: {
    async $api(url, method, data) {
      return (
        await axios({
          method: method,
          url,
          data,
        }).catch((e) => {
          console.log(e);
        })
      ).data;
    },
  },
};
