import { Admin, Resource } from "react-admin";
import { dataProvider } from "src/providers/dataProvider";
import AcquirerTestPage from "src/pages/acquirertestpage/AcquirerTestPage";

export const App = () => (
  <Admin>
    <Resource name="cases" list={AcquirerTestPage} />
  </Admin>
);