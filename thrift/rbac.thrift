namespace java com.maogogo.rbac.thrift
#@namespace scala com.maogogo.rbac.thrift

typedef string ORGANZATION_ID
typedef string EMPLOYEE_ID
typedef string USER_ID
typedef string ROLE_ID
typedef string PRIVILEGE_ID

struct Organization {
  1: ORGANZATION_ID id
  2: string name
  3: string code
  4: string parent_code
  5: optional string status
  6: optional i64 created
  7: optional i64 modified
}

struct Employee {
  1: EMPLOYEE_ID id
  2: string name
  3: optional string emp_no
  4: optional string id_card
  5: optional string birth_date
}

struct User {
  1: USER_ID id
  2: string user_name
  3: string real_name
  4: string pass_hash
  5: string salt
  6: optional string status
  7: optional i64 created
  8: optional i64 modified
}

struct Role {
  1: ROLE_ID id
  2: string name
  3: optional string status
  4: optional i64 created
  5: optional i64 modified
}

struct Privilege {
  1: PRIVILEGE_ID id
  2: string name
  3: string parent_id
  4: optional string url
  5: optional string icon
  6: optional string status
  7: optional i64 created
  8: optional i64 modified
}

struct UserRole {
  1: USER_ID user_id
  2: ROLE_ID role_id
}