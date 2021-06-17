export default {
  name: 'index',
  data() {
    return {}
  },
  methods: {
    before() {
      this.$router.push("/register");
    },
    registerRecord() {
      this.$router.push("/registerRecord");
    }
  },
  created() {
    this.$router.push("/register");
  }
}
