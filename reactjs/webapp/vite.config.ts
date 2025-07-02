import { defineConfig, loadEnv } from "vite";
import react from "@vitejs/plugin-react";
import path from 'path';

const SERVER_URL = "http://localhost:8080";

// https://vitejs.dev/config/
export default ({ mode }) => {
  process.env = { ...process.env, ...loadEnv(mode, process.cwd()) };

  const BASE_URL = process.env.VITE_SIMPLE_REST_URL ?? "/";

  return defineConfig({
    plugins: [react()],
    define: {
      "process.env": process.env,
    },
    server: {
      proxy: {
          "/api": "http://localhost:8080",
        [BASE_URL]: SERVER_URL,
      },
    },
    base: "./",
    resolve: {
      alias: {
        src: path.resolve(__dirname, 'src'),
      },
    },
  });
};