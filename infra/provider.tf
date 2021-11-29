terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "3.56.0"
    }
  }
  backend "s3" {
    bucket = "pgr301-2018-terraform"
    key    = "2018/eksamen_2021_PGR301.state"
    region = "eu-west-1"
  }
}